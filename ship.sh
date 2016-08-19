set -e
git pull -r
./gradlew clean build
git push
