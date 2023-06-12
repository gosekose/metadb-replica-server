#!/bin/bash

declare -A containers
containers=(["order-source"]="order-source" ["order-replica"]="order-replica")

# 연관 배열에 [@]를 쓰면 key, !와 [@]를 같이쓰면 key를 가져옴
for name in "${!containers[@]}"; do
  image="${containers[$name]}"

  # Check if the image exists
  if [[ "$(docker images -q "$image" 2> /dev/null)" != "" ]]; then
      echo "Image $image exists"
      
      # Check if container is running
      if [[ "$(docker ps -f "name=$name" --format '{{.Names}}' 2> /dev/null)" != "" ]]; then
          echo "Container $name is already running"
      else
          echo "Starting $name container"
          docker start "$name"
      fi
  else
      echo "Image $image does not exist, building and running"
      docker-compose up --build
  fi
done
