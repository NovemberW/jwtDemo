CREATE TABLE attachment(
    id UUID NOT NULL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    file VARCHAR(200) NOT NULL
)