
    create table Article (
        Id numeric(19,0) not null,
        Content VARBINAY(MAX),
        Title varchar(255),
        Version int,
        primary key (Id)
    )

    create table ArticleAuthors (
        ArticleId numeric(19,0) not null,
        AuthorId INTEGER64 not null
    )

    create table ArticleSeq (
       next_val numeric(19,0)
    )

    insert into ArticleSeq values ( 1 )

    create table AuthorGenerator (
        PK varchar(255) not null,
        AuthorId numeric(19,0),
        primary key (PK)
    )

    create table AuthorPublication (
       AuthorId INTEGER64 not null,
        city varchar(255),
        state varchar(255),
        street varchar(255),
        zip varchar(255),
        FirstName varchar(255),
        LastName varchar(255),
        Version int,
        primary key (AuthorId)
    )

    create table Company (
       CompanyId numeric(19,0) not null,
        City varchar(255),
        state varchar(255),
        Street varchar(255),
        zip varchar(255),
        name varchar(255),
        Revenue double precision,
        Version int,
        primary key (CompanyId)
    )

    create table CompanySubscriptions (
       CompanyId numeric(19,0) not null,
        SubscriptionId numeric(19,0) not null
    )

    create table Contract (
       ContractType varchar(31) not null,
        Id numeric(19,0) identity not null,
        Version int,
        terms varchar(255),
        primary key (Id)
    )

    create table LineItem (
       Comments varchar(255),
        Number numeric(19,0),
        Price double precision,
        Id numeric(19,0) not null,
        MagazineIsbn varchar(9),
        MagazineTitle varchar(255),
        primary key (Id)
    )

    create table Magazine (
        Isbn varchar(9) not null,
        Title varchar(255) not null,
        Copies int,
        Name varchar(255),
        Price double precision,
        Version int,
        CoverId numeric(19,0),
        PublisherId numeric(19,0),
        primary key (Isbn, Title)
    )

    create table MagazineArticles (
        MagazineIsbn varchar(9) not null,
        MagazineTitle varchar(255) not null,
        ArticleId numeric(19,0) not null
    )

    create table SubscribedItems (
       SubscriptionId numeric(19,0) not null,
        Itemid numeric(19,0) not null,
        primary key (SubscriptionId, Itemid)
    )

    create table Subscription (
        Kind int not null,
        Id numeric(19,0) identity not null,
        Payment double precision,
        StartDate datetime,
        Version int,
        eliteClub bit,
        endDate datetime,
        primary key (Id)
    )

    alter table CompanySubscriptions 
       add constraint UK_COMPANY_SUBSCRIPTIONS_SUBSCRIPTION_ID unique (SubscriptionId)

    alter table MagazineArticles 
       add constraint UK_MAGAZINE_ARTICLES_ARTICLE_ID unique (ArticleId)

    alter table SubscribedItems 
       add constraint UK_SUBSCRIBED_ITEMS_ITEM_ID unique (Itemid)

    alter table ArticleAuthors 
       add constraint FK_ARTICE_AUTHORS_AUTHOR_ID
       foreign key (AuthorId) 
       references AuthorPublication

    alter table ArticleAuthors 
       add constraint FK_ARTICE_AUTHORS_ARTICLE_ID 
       foreign key (ArticleId) 
       references Article

    alter table CompanySubscriptions 
       add constraint FK_COMPANY_SUBSCRIPTIONS_SUBSCRIPTION_ID
       foreign key (SubscriptionId) 
       references Subscription

    alter table CompanySubscriptions 
       add constraint FK_COMPANY_SUBSCRIPTIONS_COMPANY_ID 
       foreign key (CompanyId) 
       references Company

    alter table LineItem 
       add constraint FK_LINE_ITEM_ISBN_TITLE
       foreign key (MagazineIsbn, MagazineTitle) 
       references Magazine

    alter table LineItem 
       add constraint FK_LINE_ITEM_ID
       foreign key (Id) 
       references Contract

    alter table Magazine 
       add constraint FK_MAGAZINE_COVER_ID
       foreign key (CoverId) 
       references Article

    alter table Magazine 
       add constraint FK_MAGAZINE_PUBLISHER_ID 
       foreign key (PublisherId) 
       references Company

    alter table MagazineArticles 
       add constraint FK_MAGAZINE_ARTICLES_ARTICLE_ID
       foreign key (ArticleId) 
       references Article

    alter table MagazineArticles 
       add constraint FK_MAGAZINE_ARTICLES_ISBN_TITLE 
       foreign key (MagazineIsbn, MagazineTitle) 
       references Magazine

    alter table SubscribedItems 
       add constraint FK_SUBSCRIBED_ITEMS_ITEM_ID 
       foreign key (Itemid) 
       references LineItem

    alter table SubscribedItems 
       add constraint FK_SUBSCRIBED_ITEMS_SUBCRIPTION_ID
       foreign key (SubscriptionId) 
       references Subscription
