docker stop sys-web
docker rm -f sys-web
docker rmi sys-web
docker build -t sys-web .
docker images
docker run --restart=always -t -dit -p 18081:18081 --name sys-web sys-web
docker ps
