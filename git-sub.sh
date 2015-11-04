#!/bin/bash

read -p "Insert file: " FILE
read -p "Commit description: " desc
git add "$FILE"
git commit -m "$desc" && \
git push origin origin/luis
