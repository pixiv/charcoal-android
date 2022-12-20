import yargs from 'yargs'
import { hideBin } from 'yargs/helpers'
import { FoundationGenerator } from './FoundationGenerator.js'

yargs(hideBin(process.argv))
  .command(
    'generate',
    '',
    (yargs) => {
      return yargs
        .positional('input', {
          describe: 'input',
          type: 'string',
        })
        .positional('output', {
          describe: 'output xml directory',
          type: 'string',
        })
        .positional('outputJson', {
          describe: 'output json directory',
          type: 'string',
        })
        .positional('outputKotlin', {
          describe: 'output kotlin directory',
          type: 'string',
        })
    },
    ({ input, output, outputJson, outputKotlin }) => {
      void FoundationGenerator.runFromCli(input, output, outputJson, outputKotlin).catch((e) => {
        console.error(e)
        process.exit(1)
      })
    }
  )
  .help()
  .parse()
