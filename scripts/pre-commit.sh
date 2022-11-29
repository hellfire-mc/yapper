#!/usr/bin/env bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
cd "$SCRIPT_DIR"/../../ || exit

ls -al

./gradlew spotlessApply

git add $(git diff --name-only --cached)
