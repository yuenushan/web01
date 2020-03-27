TAG ?= latest
IMAGE_NAME = web01
CONTAINER_NAME = web01

.PHONY: jar
jar:
	mvn clean package -Dmaven.test.skip=true

.PHONY: build
build: jar
	echo ${TAG}
	docker build -t ${IMAGE_NAME}:${TAG} .

.PHONY: run
run:
	docker run --name=${CONTAINER_NAME} -e LOG_LEVEL=DEBUG -d -p 8080:8080 ${IMAGE_NAME}:${TAG}

.PHONY: clean
clean:
	docker stop ${CONTAINER_NAME}
	docker rm ${CONTAINER_NAME}
