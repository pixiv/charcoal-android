warn("Big PR") if git.lines_of_code > 300

# Checkstyle
begin
  checkstyle_reports.inline_comment=true
  checkstyle_reports.report_method=:warn

  Dir.glob("**/ktlint*Check.xml").each do |xml|
    checkstyle_reports.report(xml, modified_files_only: true)
  end
end

