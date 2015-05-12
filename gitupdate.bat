@ECHO OFF
CLS
ECHO --------------------------------------------
ECHO ADDING ALL NEW FILES (git add -A)
ECHO --------------------------------------------

git add -A

ECHO files added

ECHO --------------------------------------------
ECHO COMMITTING CHANGES (git commit)
ECHO --------------------------------------------

set /p message="Enter commit message: "

git commit -m message

ECHO --------------------------------------------
ECHO SENDING FILES TO GITHUB.COM (git push)
ECHO --------------------------------------------
git push

ECHO --------------------------------------------
ECHO done!
ECHO --------------------------------------------