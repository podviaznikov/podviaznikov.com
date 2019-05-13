FROM scratch as deploy

# Copy only the public files over to the final image. This way any secrets you
# may require while building will not be in the final image
COPY --from=build /app/public /public
