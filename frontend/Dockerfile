# Use the official NGINX image
FROM nginx:alpine

# Remove the default NGINX website
RUN rm -rf /usr/share/nginx/html/*

# Copy your frontend files into the NGINX web root
COPY . /usr/share/nginx/html

# Expose port 80 (NGINX default)
EXPOSE 80

# NGINX starts automatically — no need for custom CMD