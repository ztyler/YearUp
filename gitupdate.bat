TITLE update-git
@ECHO OFF
CLS
ECHO --------------------------------
ECHO ADDING ALL NEW FILES
ECHO --------------------------------

git add -A

ECHO files added

ECHO --------------------------------
ECHO COMMITTING CHANGES
ECHO --------------------------------

git commit

ECHO --------------------------------
ECHO SENDING FILES TO GITHUB.COM
ECHO --------------------------------
git push

ECHO --------------------------------
ECHO done!
ECHO --------------------------------