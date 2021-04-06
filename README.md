# simbirsoftApplication


This app downloads and writes the HTML into C:\\SavedHtmls directory (will create, if not created), prints the result into terminal and saves the data into postgresql.


Libraries used in this application:
slf4j - logging
postgresql driver - db
jsoup - parsing

---------------------------------------

Requirements:
Java 8+
Postgresql with preinstalled schema + table
(schema name - frequency_schema)

create table frequency_table
(
    id    serial  not null,
    body  varchar not null,
    count integer not null,
    date  date    not null,
    url   varchar not null
);

alter table frequency_table
    owner to postgres;

create unique index frequency_table_id_uindex
    on frequency_table (id);
    
---------------------------------------

Running:
1. Download the zip file.
2. In command line, navigate to C:\...\simbirsoftApplication-master\out\artifacts\simbirsoftTest_jar
3. Type java -cp simbirsoftTest.jar Main [site for parsing], e.x: java -cp simbirsoftTest.jar Main https://www.simbirsoft.com/

---------------------------------------

