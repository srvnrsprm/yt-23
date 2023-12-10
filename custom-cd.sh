myCd() {
  rmAllDts=${1%%..*}
  rmAllDtsWthSlsh=${1%%../*}

  if [ -n "$1" -a -z "$rmAllDts" -a -n "$rmAllDtsWthSlsh" ]; then
    tms=${#1}
    until [ $tms -eq 1 ]; do
      builtin cd ..
      tms=$((tms-1))
    done
  else
    builtin cd $1
  fi
}
