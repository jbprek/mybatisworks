#!/bin/bash
export DOCKER_DATA_DIR=$HOME/data
mkdir -p $DOCKER_DATA_DIR
docker run -h db2server_ \
        --name db2server --restart=always \
        --detach \
        --privileged=true \
        -p 50000:50000 -p 55000:55000 \
        --env-file env_list \
        -v $DOCKER_DATA_DIR:/db2/database \
        store/ibmcorp/db2_developer_c:11.1.4.4-x86_64