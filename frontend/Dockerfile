FROM node:alpine as base

WORKDIR '/opt/work-dir/'

COPY ./package.json ./

RUN npm install

COPY ./ ./

RUN npm run build

FROM nginx
EXPOSE 80

COPY --from=base /opt/work-dir/build /usr/share/nginx/html