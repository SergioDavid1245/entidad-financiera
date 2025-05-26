#!/bin/bash

# Configura estas variables según tu entorno
AWS_REGION="us-east-1"
AWS_ACCOUNT_ID="263377767970"
REPO_NAME="entidad-financiera"
IMAGE_TAG="latest"

# Variables de entorno para tu contenedor
SPRING_DATASOURCE_URL="jdbc:mysql://entidadfinanciera.c6zhks5mx4tw.us-east-1.rds.amazonaws.com"
SPRING_DATASOURCE_USERNAME="admin"
SPRING_DATASOURCE_PASSWORD="DbxL3UQYgmilAfnWuHqw"

echo "Autenticando en ECR..."
aws ecr get-login-password --region $AWS_REGION | \
  docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com

if [ $? -ne 0 ]; then
  echo "Falló la autenticación en ECR."
  exit 1
fi

echo "Descargando la imagen desde ECR..."
docker pull ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${REPO_NAME}:${IMAGE_TAG}

# Detener el contenedor solo si existe
if [ "$(docker ps -q -f name=entidad-financiera)" ]; then
  docker stop tienda-virtual
fi

# Eliminar el contenedor solo si existe
if [ "$(docker ps -aq -f name=entidad-financiera)" ]; then
  docker rm entidad-financiera
fi

echo "Iniciando nuevo contenedor..."
docker run -d \
  --name ${REPO_NAME} \
  -e SPRING_DATASOURCE_URL=$SPRING_DATASOURCE_URL \
  -e SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME \
  -e SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD \
  -p 8080:8080 \
  ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${REPO_NAME}:${IMAGE_TAG}

echo "Contenedor desplegado correctamente."