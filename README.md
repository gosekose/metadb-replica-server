리플리카 서버 적용
======================
<br/><br/>

# 1. MySQL 리플리카 서버 분리
- https://gose-kose.tistory.com/131
- 리플리카 데이터베이스를 도커로 연동하였습니다.

# 2. 서버 설정하기 
- https://gose-kose.tistory.com/132
- transactional readOnly를 활용하여 source - replica 서버를 선택할 수 있도록 하였습니다.

# 3. 캐싱 적용하기 
- 어노테이션으로 캐시를 적용하였지만, 더 좋은 방법에 대한 고찰이 필요합니다.

# 4. 리플리카 서버에 배치 적용하기
