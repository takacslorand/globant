# GOT Client wrapper - tutorial 


Feign client for https://anapioficeandfire.com/Documentation#intro I tried to keep as simple is possible only to show the different possibilities to achieve
this:

- Spring boot OpenFeign:
  ````
  RequestMapping(value = "/houses", method = RequestMethod.GET)
  @HandleFeignException(FeignClientExceptionHandler.class)
  List<House> all(@SpringQueryMap Map<String, String> queryParams);
  ````
- Feign @Requestline 
  ````
  @RequestLine(value = "GET /books")
  @Headers("Content-Type: application/json")
  @HandleFeignException(FeignClientExceptionHandler.class)
  List<Book> all(@QueryMap Map<String, String> queryMap);
  ````
### Error handling 
 Tutorial on how to handle exceptions, on both clients

### Testing 
  
 Integration and Cucumber test examples/setup 
 
