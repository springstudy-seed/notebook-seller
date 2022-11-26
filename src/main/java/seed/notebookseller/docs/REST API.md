### REST API

* **URI**는 정보의 **자원**을 표현한다

* 자원에 대한 **행위**는 **HTTP Method**(GET,POST,PUT,PATCH)로 표현한다.

  

#### HTTP Method의 속성

---

* 안전(Safe) : 호출해도 resource를 변경하지 않음
  * GET, HEAD -> 안전
  * POST,PUT,DELETE -> 안전하지 않음(리소스를 수정하거나 삭제하기 때문)
* 멱등(Idempotent) : 여러 번 호출해도 같은 결과를 가져옴
  * GET,HEAD -> 멱등(읽기 작업)
  * PUT,DELETE -> 멱등(리소스를 덮어쓰거나 삭제한 후 같은 결과를 반환)
  * POST -> 멱등하지 않음(호출할 때마다 새로운 리소스를 반환)

#### HTTP 메서드의 속성

---

##### GET

* 서버에 전달하고 싶은 데이터는 쿼리(쿼리 파라미터, 쿼리 스트링)를 통해서 전달
* 메시지 바디를 사용해서 전달하는 것은 권장하지 않음

#### ![스크린샷 2022-11-23 오후 6.16.06](/Users/suminkim/Library/Application Support/typora-user-images/스크린샷 2022-11-23 오후 6.16.06.png)

328 리소스를 서버로 전달하기 위해서 URL에 담고 요청을 보내면
서버에서 요청을 받아 적절한 데이터를 찾아낸다.
클라이언트로 HTTP body에 데이터를 담아 보낸다.



##### POST

* 메시지 바디를 통해 서버로 리소스 전달
* 다른 메서드로 처리하기 애매한 경우, POST 사용

![스크린샷 2022-11-23 오후 6.18.16](/Users/suminkim/Library/Application Support/typora-user-images/스크린샷 2022-11-23 오후 6.18.16.png)

HTTP 메시지 바디에 리소스를 담아서 서버로 요청을 보내면,
데이터베이스에 신규 회원을 등록하고 새로운 리소스로 식별자를 생성한다.
이후 클라이언트로 Location Header를 통해 해당 자원이 생성된 경로와 데이터를 함꼐 보내준다.



##### PUT

* 기존 리소스가 존재한다면 대체하고, 없다면 새로 생성함
* 클라이언트가 리소스의 위치를 알고 URI를 지정한다.
* 하지만, PUT 메서드에서는 리소스 전체를 대체하므로 부분적인 변경이 필요할 떄는 PATCH를 사용한다.

![스크린샷 2022-11-23 오후 6.21.47](/Users/suminkim/Library/Application Support/typora-user-images/스크린샷 2022-11-23 오후 6.21.47.png)

#### ![스크린샷 2022-11-23 오후 6.23.45](/Users/suminkim/Library/Application Support/typora-user-images/스크린샷 2022-11-23 오후 6.23.45.png)



##### PATCH

* 기존에 존재하는 리소스를 부분적으로 변경

![스크린샷 2022-11-25 오전 8.18.01](/Users/suminkim/Library/Application Support/typora-user-images/스크린샷 2022-11-25 오전 8.18.01.png)

**DELETE**

* 리소스를 삭제할 떄 사용



따라서 자원의 일부를 수정할 떄는 PATCH를, 전체적인 수정이 필요할 때는 PUT을 사용한다.



#### RESTful한 URL 설계

---

HTTP Method는 GET,POST,PUT,DELETE가 대표적이다.

일반적으로 CRUD에서 조회는 GET, 등록은 POST, 수정은 PUT, 삭제는 DELETE를 이용한다.



* Resource의 형태
* Resource는 서브 Resource를 포함할 수 있다.
  * 2번 손님의 모든 계좌 customers/2/accounts
  * 2번 손님의 2번 계좌 ustomers/2/accounts/2

1. 소문자를 사용하자

   ```jav
   http://restapi.example.com/users/post-comments
   ```

2. 언더바 대신 하이픈을 사용한다.

   -> 하이픈 사용도 자제

   ```jav
   http://restapi.example.com/users/post_comments(bad)
   http://restapi.example.com/users/post-comments(good)
   ```

3. 마지막에 슬래시를 포함하지 않는다.

   -> 슬래시는 계층을 뜻한다.

   ```jav
   http://restapi.example.com/users/post-comments/(bad)
   http://restapi.example.com/users/post-comments(good)
   ```

4. 행위는 포함하지 않는다.

   -> 행위는 HTTP Method를 사용한다.

   ```ja
   DELETE http://restapi.example.com/users/delete-post/1 (bad)
   DELETE http://restapi.example.com/users/posts/1 (good)
   ```

5. 파일의 확장자는 URI에 포함시키지 않는다.

   -> Accept header를 사용한다.

   ```ja
   http://restapi.example.com/users/photo.jpg (bad)
   
   GET http://restapi.example.com/users/photos
   HTTP/1.1 HOST : restapi.example.com Accept: image/jpg
   ```

6. 가급적 전달하고자 하는 자원의 명사를 사용하자!

   

   

#### Content-Type vs Accept Header

---

* Content-Type : HTTP 메시지에 담겨 보내는 데이터의 형식을 알려주는 Header

  * Content-Type이 없이 front에서 데이터를 보내면 특별한 형식일지라도 server에서는 text 데이터로 받는다.

  * GET 요청시 URL의 끌에 value=text 형식으로 보내지기 때문에 Content-Type이 따로 필요없다.

  * 하지만, POST ,PUT은 HTTP body에 담겨서 데이터를 보내기 때문에

    Ajax를 통해 json으로 데이터를 전송하면 Content-Type을 application/json으로

    <form> 태그를 통해 데이터를 전송하면 Content-Type을 multipart/form-data로 설정해야 한다.

* Accept : Server로 요청시 HTTP Request Header에 담김

  특정 데이터 형식만 받을 수 있다고 알려줌 -> 서버는 따라서 그 데이터 타입으로 응답해야 함

  * Accept 이 application/json이면 웹 서버에서 json 형식의 데이터만 처리할 수 있으니 json 형식으로 응답을 해달라고 요청하는 것임