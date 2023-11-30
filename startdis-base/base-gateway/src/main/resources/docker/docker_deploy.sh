docker stop gateway
docker rm -f gateway
docker rmi gateway
docker build -t gateway .
docker images
docker run --restart=always -t -dit -p 18080:18080 --name gateway gateway
docker ps
