--09_JOIN.SQL

select*from emp;
select*from dept;

drop table emp2;
create table emp2 as select ename, deptno from emp where job = 'SALESMAN';


-- [1]사원명이 'SCOTT'인 사원의 부서명을 알고 싶을 때
SELECT*FROM emp;
select deptno from emp where ename ='SCOTT';
SELECT dname from dept where deptno = 20;
--서브 쿼리 사용
select dname from dept where deptno=(select deptno from emp where ename='SCOTT');

--JOIN
--두개 이상의 테이블에 나눠져 있는 관련 데이터들을 하나의 테이블로 모아서 조회하고자 할때 사용하는 명령


--cross join : 두개 이상의 테이블이 조인
	--가장 최악의 결과 조건을 얻는조인 방식
select*from emp2,dept;


--equi join : 조인 대상이 되는 두테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성
select*from emp2,dept where emp2.deptno = dept.deptno;

select*from emp2 a, dept b where a.deptno = b.deptno;

select*from emp2 a, dept b where a.deptno = b.deptno;

--rentlist의 대여일자, 대여도서번호, 대여회원번호, 할인금액을 출력하되, 도서의 제목을
--도서번호 옆에 출력하세요
select a.rent_date, b.subject, a.bnum, a.mnum, a.discount from rentlist a, booklist b
where a.bnum = b.booknum;

--rentlist의 대여일자, 대여도서번호, 대여회원번호, 할인금액을 출력하되, 회원의 이름을 대여회원번호 옆에 출력하세요.
select a.rent_date, a.bnum, a.mnum, b.name, a.discount from rentlist a, memberlist b
where a.mnum = b.membernum;


--rentlist의 대여일자, 대여도서번호, 대여회원번호, 할인금액을 출력하되, 도서의 제목,회원의 이름을
--도서번호와 회원번호 옆에 출력하세요
select a.rent_date, a.bnum, b.subject, a.mnum, c.name, a.discount , b.rentprice-a.discount as "매출액" 
from rentlist a, booklist b, memberlist c
where a.bnum = b.booknum and a.mnum = c.membernum;
select * from rentlist;
select * from BOOKLIST;
select * from memberlist;

--non-equi join
--동일 컬럼이 없어서 다른 조건을 사용하여 조인
--조인 조건의 특정 범위내에 있는지를 조사하기 위해 조건절에 조인 조건을 '='연산자 이외의 비교
select*from emp;
select*from salgrade;

select a.ename, a.sal, b.grade
from emp a, salgrade;
where a.sal >= b.losal and a.sal <= b.hisal;

select a.ename, a.sal, b.grade
from emp a, salgrade;
where a.sal between b.losal and b.hisal;


--outer join
--조인 조건에 만족하지 못해서 해당 결과를 출력시에 누락이 되는 문제점이 발생할때 해당 레코드를 출력하는 조인
select a.booknum, a.subject, b.rentdate from booklist a, rentlist b
where a.booknum=b.num(+)

-- emp 테이블에는 deptno가 40인 레코드가 하나도 없습니다. 그래서 조인된 결과에는 40번 부서의 이름도 loc도 표시가 안됩니다.
select*from emp a, dept b
where a.deptno(+)=b.deptno;

--ANSI join

--일반 equi 조인
select a.ename, b.dname
from emp a, dept b
where a.deptno = b.deptno;

--Ansi inner join
--Ansi 이너 조인의 표현방식
select ename, dname
from emp inner join dept on emp.deptno=dept.deptno;

--Ansi 이너 조인의 표현방식 --서로비교되는 필드명이 같을때만 사용
select ename, dname
from emp inner join dept using(deptno);

--Ansi Outer Join
--기존 아우터 조인의 표현방식
select*from emp, dept
where emp.deptno(+) = dept.deptno;

select*from rentlist, booklist
where rentlist.bnum(+) = booklist.booknum;

--Ansi Outer Join 표현방식
select*from emp right outer join dept on emp.deptno = dept.deptno
select*from rentlist right outer join booklist on rentlist.bnum = booklist.booknum;












