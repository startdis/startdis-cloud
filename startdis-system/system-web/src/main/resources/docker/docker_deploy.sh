docker stop system-web
docker rm -f system-web
docker rmi system-web
docker build -t system-web .
docker images
docker run --restart=always -t -dit -p 21020:21020 -e TZ="Asia/Shanghai" --name system-web system-web
docker ps
