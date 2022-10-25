docker stop system-web
docker rm -f system-web
docker rmi system-web
docker build -t system-web .
docker images
docker run --restart=always -t -dit -p 18080:18080 -e TZ="Asia/Shanghai" --name system-web system-web
docker ps
