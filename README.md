# Spring-Boot-Microservices
# It contains three Microservices
# MovieCatalog Service
# MovieInfoService
# RatingsDataService

# MovieCatalogService will call the MovieInfoService for moviesinformation  using RestTemplate

# MovieCatalogService will call the RatingsDataService for moviesinformation  using RestTemplate

# It contains a Eureka Server for Discovery Server ,its like a Service Registry basically all three microservices get registered in Eureka Server for communication discovery and it enables a communication between different microservices like if one microservices need to call other microservices it needs to call through Eureka Server

# Eureka Server is Client Side Service Discovery eg if  movie catalog service need to call movieinfoservice then first it will ask to eureka server its address or location of this service and eureka server has it in service registry and after that only moviecatalog service will directly call the movieinfo service i,e  Client(MovieCatalogService) will directly call the MovieInfoService
