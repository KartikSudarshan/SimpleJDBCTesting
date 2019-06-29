A simple way to create the container with the preloaded data is to simply copy all _.sql_ and _.sh_ files to the _/docker-entrypoint-initdb.d/_ folder while creating the image.
The scripts would be executed alphabetically. However PostgreSQL does not have a way to simultaneously use different databases (the USE statement in MySQL to switch between DBs)
Hence we need to ensure that the Host machine already has the PostgreSQL client installed. This is so that we can load the data into the databases using psql

> docker run --rm --name lil-postgres -e POSTGRES_PASSWORD=mysecretpassword -d  -p 5432:5432 postgres

> psql -h localhost -U postgres -f database.sql
> psql -h localhost -U postgres -d hplussport -f customer.sql
> psql -h localhost -U postgres -d hplussport -f product.sql
> psql -h localhost -U postgres -d hplussport -f salesperson.sql
> psql -h localhost -U postgres -d hplussport -f orders.sql