import path from 'path'
import { promises as fs } from 'fs'
import { quicktype, InputData, jsonInputForTargetLanguage } from 'quicktype-core'

const targetLanguage = 'kotlin'
const foundationFileName = 'CharcoalFoundation'

export class FoundationGenerator {
  input
  output
  jsonOutputDir
  kotlinOutputDir

  static async runFromCli(input, output, jsonOutputDir, kotlinOutputDir) {
    const client = new this(input, output, jsonOutputDir, kotlinOutputDir)
    await client.createFoundation()
    console.log('success!')
  }

  constructor(input, output, jsonOutputDir, kotlinOutputDir) {
    this.input = input
    this.output = output
    this.jsonOutputDir = jsonOutputDir
    this.kotlinOutputDir = kotlinOutputDir
  }

  async createFoundation() {
    const source = await fs.readFile(this.input, 'utf8')
    const data = JSON.parse(source)
    const { light, dark } = data
    await this.createKotlinFoundation(light)
    await this.createXmlFoundation(light, dark)
  }

  async createKotlinFoundation(theme) {
    try {
      await fs.rm(this.kotlinOutputDir, { recursive: true })
      await fs.rm(this.jsonOutputDir, { recursive: true })
    } catch (e) {
      if (e.code !== 'ENOENT') {
        throw e
      }
    }

    const jsonInput = jsonInputForTargetLanguage(targetLanguage)

    const { borderRadius, spacing, typography, color } = theme
    const outputData = JSON.stringify({ borderRadius, spacing, typography, color })

    await jsonInput.addSource({
      name: foundationFileName,
      samples: [outputData],
    })

    const inputData = new InputData()
    inputData.addInput(jsonInput)

    let { lines: kotlinData } = await quicktype({
      inputData,
      lang: targetLanguage,
      inferMaps: false,
      rendererOptions: {
        'package': 'net.pixiv.charcoal.android.compose.generated',
        'framework': 'kotlinx',
      },
    })

    await fs.mkdir(this.kotlinOutputDir, { recursive: true })
    await fs.writeFile(path.join(this.kotlinOutputDir, `${foundationFileName}.kt`), kotlinData.join('\n'))
    await fs.mkdir(this.jsonOutputDir, { recursive: true })
    await fs.writeFile(path.join(this.jsonOutputDir, `${foundationFileName}.json`), outputData)
  }

  async createXmlFoundation(light, dark) {
    for (const type of Object.keys(light)) {
      if (type === 'borderRadius' || type === 'spacing') {
        const xml = createDimensXml(type, light[type])
        await fs.writeFile(path.join(this.output, `${snakeCase(type)}_generated.xml`), xml)
      }
      if (type === 'typography') {
        const xml = createTypographyDimensXml(type, light[type])
        await fs.writeFile(path.join(this.output, `${snakeCase(type)}_generated.xml`), xml)
      }
      if (type === 'color') {
        const lightXml = createColorsXml(type, light[type], 'light')
        await fs.writeFile(path.join(this.output, `${snakeCase(type)}_light_generated.xml`), lightXml)

        const darkXml = createColorsXml(type, dark[type], 'dark')
        await fs.writeFile(path.join(this.output, `${snakeCase(type)}_dark_generated.xml`), darkXml)
      }
      if (type === 'gradientColor') {
        const lightXml = createGradientColorsXml(type, light[type], 'light')
        await fs.writeFile(path.join(this.output, `${snakeCase(type)}_light_generated.xml`), lightXml)

        const darkXml = createGradientColorsXml(type, dark[type], 'dark')
        await fs.writeFile(path.join(this.output, `${snakeCase(type)}_dark_generated.xml`), darkXml)
      }
    }
  }
}

function createDimensXml(type, dimens) {
  let xml = ''
  xml += '<?xml version="1.0" encoding="utf-8"?>\n'
  xml += '<resources>\n'

  for (const key of Object.keys(dimens)) {
    xml += `    ${createDimenXml(type, key, dimens[key])}\n`
  }

  xml += '</resources>'
  return xml
}

function createTypographyDimensXml(type, typographies) {
  let xml = ''
  xml += '<?xml version="1.0" encoding="utf-8"?>\n'
  xml += '<resources>\n'

  for (const size of Object.keys(typographies.size)) {
    const typography = typographies.size[size]
    xml += `    ${createDimenSpXml(type, `${size}_font_size`, typography.fontSize)}\n`
    xml += `    ${createDimenSpXml(type, `${size}_line_height`, typography.lineHeight)}\n`
  }

  xml += '</resources>'
  return xml
}

function createDimenXml(type, key, value) {
  return `<dimen name="charcoal_${snakeCase(type)}_${key}">${value}dp</dimen>`
}

function createDimenSpXml(type, key, value) {
  return `<dimen name="charcoal_${snakeCase(type)}_${key}">${value}sp</dimen>`
}

function createColorsXml(type, colors, appearance) {
  let xml = ''
  xml += '<?xml version="1.0" encoding="utf-8"?>\n'
  xml += '<resources>\n'

  for (const key of Object.keys(colors)) {
    xml += `    ${createColorXml(type, key, hexCode(colors[key]), appearance)}\n`
  }

  xml += '</resources>'
  return xml
}

function createGradientColorsXml(type, gradients, appearance) {
  let xml = ''
  xml += '<?xml version="1.0" encoding="utf-8"?>\n'
  xml += '<resources>\n'

  for (const name of Object.keys(gradients)) {
    for (const gradient of gradients[name]) {
      xml += `    ${createColorXml(type, `${name}_${gradient.ratio}`, hexCode(gradient.color), appearance)}\n`
    }
  }

  xml += '</resources>'
  return xml
}

function createColorXml(type, key, value, appearance) {
  return `<color name="charcoal_${snakeCase(type)}_${snakeCase(key)}_${appearance}">${value}</color>`
}

function snakeCase(str) {
  return str
    .split(/(?=[A-Z])/)
    .join('_')
    .toLowerCase()
}

function hexCode(color) {
  const a = ('0' + Math.round(color.alpha * 255).toString(16)).slice(-2)
  const r = ('0' + Math.round(color.red * 255).toString(16)).slice(-2)
  const g = ('0' + Math.round(color.green * 255).toString(16)).slice(-2)
  const b = ('0' + Math.round(color.blue * 255).toString(16)).slice(-2)
  return `#${a}${r}${g}${b}`
}
