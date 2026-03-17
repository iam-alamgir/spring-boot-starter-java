#!/usr/bin/env bash
set -euo pipefail
if [ "$#" -ne 4 ]; then
  echo "Usage: $0 <project-name> <group-id> <artifact-id> <base-package>"
  exit 1
fi
PROJECT_NAME="$1"; GROUP_ID="$2"; ARTIFACT_ID="$3"; BASE_PACKAGE="$4"
find . -name pom.xml -type f -exec sed -i "s|<groupId>com.example</groupId>|<groupId>${GROUP_ID}</groupId>|g" {} +
find . -name pom.xml -type f -exec sed -i "s|<artifactId>spring-boot-starter-java</artifactId>|<artifactId>${ARTIFACT_ID}</artifactId>|g" {} +
sed -i "s|spring-boot-starter-java|${PROJECT_NAME}|g" README.md boot/src/main/resources/application.yml
echo "Updated project metadata. Package move to ${BASE_PACKAGE} should be done with IDE refactor for safety."
