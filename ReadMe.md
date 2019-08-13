# Discovery Server

######  Project MO

MSA 내 여러 인스턴스 정보를 중앙 관리하는 서버입니다.



> 구성 정보

- registerWithEureka : 유레카 서비스에 자신 등록
- fetchRegistry : 레지스트리 정보 로컬 캐싱
- waitTimeInMsWhenSyncEmpty : 서버가 요청을 받기 전 대기할 초기 시간

```yaml 
eureka:
  instance:
    hostname: localhsot
  client:
    registerWithEureka: false 
    fetchRegistry: false
  server:
    waitTimeInMsWhenSyncEmpty: 5 
  serviceUrl:
    defaultZone: http://${eureka.instance.hostname}:8761
```

> Instance 정보 확인 하기

- 다음의 주소로 접근하면 연결된 Instance 정보를 확인 가능합니다.
  - http://{{host}}:8761



## Discovery 연동

Discovery 서버에 인스턴스 정보를 명세하지 않습니다.

각각의 서버에서 아래정보와 같이 Discovery 서버를 연동합니다.

```yaml
eureka:
  instance:
    hostname: ${env.host.local}
  client:
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:8761/eureka/
```

