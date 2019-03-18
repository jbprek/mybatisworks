DB2 Related staff
===================

References
----------
http://db2express.com/en/

Docker 
------
[Site Image and Instructions](https://hub.docker.com/_/db2-developer-c-edition)


####Current Setup

 - run script in docker/run.sh directory
 - Data dir in  $HOME/docker_data
  
#####Log on to the container
docker exec -ti db2server bash -c "su - ${DB2INSTANCE}" 
