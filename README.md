For build the docker image:

docker build -t esame-app-container .

For execute the docker image you can use the command:

docker run -it --rm esame-app-container

the flag --rm removes it when I stop.

If I create the container in DM:

docker-compose up -d
