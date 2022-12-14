PGDMP         %        	        z         
   phoneverse    13.8    13.8     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16431 
   phoneverse    DATABASE     n   CREATE DATABASE phoneverse WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE phoneverse;
                postgres    false            ?            1259    16450 	   customers    TABLE     ?   CREATE TABLE public.customers (
    id bigint NOT NULL,
    customer_name character varying(255),
    outlet character varying(255),
    payment_method character varying(255),
    tanggal_lahir date
);
    DROP TABLE public.customers;
       public         heap    postgres    false            ?            1259    16448    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          postgres    false    202            ?           0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          postgres    false    201            ?            1259    16440    products    TABLE     ?   CREATE TABLE public.products (
    sku character varying(255) NOT NULL,
    buy_date date,
    harga integer,
    item_name character varying(255),
    sell_date date,
    status character varying(255),
    storage character varying(255)
);
    DROP TABLE public.products;
       public         heap    postgres    false            (           2604    16453    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    202    202            ?          0    16450 	   customers 
   TABLE DATA           ]   COPY public.customers (id, customer_name, outlet, payment_method, tanggal_lahir) FROM stdin;
    public          postgres    false    202   ?       ?          0    16440    products 
   TABLE DATA           _   COPY public.products (sku, buy_date, harga, item_name, sell_date, status, storage) FROM stdin;
    public          postgres    false    200   <       ?           0    0    customers_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.customers_id_seq', 18, true);
          public          postgres    false    201            ,           2606    16458    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    202            *           2606    16447    products products_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (sku);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    200            ?   ?   x???1
1@?z??@$??f?Z?-??fVFB4?xz-D?r??o~?R?R?ي?z??????9?.X
??'???W>?U`%Si?lб?cYǼS:?t?tA?:???.?F??xa?????F/?,e??Bf?"??k&<,?	?w?C      ?      x????r?@?k|
^ StK?T?f???Y?~?D+X?L?ӷ????Ӝ>T??H?"????E@
?'?{?Xb??g?0Hv$???p?,)????e???I?*?Q??*>??tk???u??aL+?w?6????(1Dբ?R??䫎#8?S?^RV閔??kZr???xYjJ?Q??]?j)%08??S@?????z;???'¤:?uQ???Q????qBҌ??)?*???`???w???Pwc^ʬ?z?????挙?
g????Y2??|f???cJ"ƍ??c?ܷU??~sn??GY???sB?c?m#D	?-???CHX?ג?Z?1zr??ס?"??P?UP$??t28Qo5???{I?5???RWA)?"??k?A?????l'/J?wV??+??܎:?%??\?R>g????!??m?Al)???63e??E??#u??]??I??^??5?u?F??#u?w%??R??K,#???????<Z??+?q(\=??Ճ?????`0?j?j     