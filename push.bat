@echo off
echo "DOCS PUSH BAT"

echo "1. Start submitting code to the local repository"
git add *
 
echo "2. Commit the changes to the local repository"
echo "1 feat 2 fix 3 docs 4 style 5 perf 6 merge 7 revert"
echo.
echo "Please select type serial number"
set /p type=
echo "Please enter the comment for change"
set /p comment=
if %type% == 1 (
set comment="feat:" %comment%)
if %type%==2 (
set comment="fix:" %comment%)
if %type%==3 (
set comment="docs:" %comment%)
if %type%==4 (
set comment="style:" %comment%)
if %type%==5 (
set comment="perf:" %comment%)
if %type%==6 (
set comment="merge:" %comment%)
if %type%==7 (
set comment="revert:" %comment%)

echo "Change comment:" %comment%
git commit -m "%comment%"
 
echo "3. Push the changes to the remote git server"
git push
 
echo "Batch execution complete!"
pause
