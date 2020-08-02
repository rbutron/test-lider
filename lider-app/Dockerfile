# Stage 1
FROM node:14.7.0-alpine as node

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build-dev
# RUN npm run build-prod #Ambiente productivo

# Stage 2
FROM nginx

RUN rm /etc/nginx/nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=node /usr/src/app/nginx/nginx.conf /etc/nginx

COPY --from=node /usr/src/app/dist/lider-app /usr/share/nginx/html/