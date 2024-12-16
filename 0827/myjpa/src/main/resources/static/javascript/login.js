const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
  container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
});

const idcheck = () => {
  //비동기 요청 객체 생성
  let req = new XMLHttpRequest();

  //비동기 요청에 대한 응답이 오면 자동 호출될 핸들러 등록
  //받은 응답은 비동기 객체의 responseText 속성에 저장됨
  //res: {"flag":true}
  req.onload = () => {
    let res = document.getElementById("res");
    let msg = '중복된 아이디';
    let obj = JSON.parse(req.responseText);
    if(!obj){
      msg = '사용가능한 아이디';
    }
    res.innerHTML = msg;
  }

  //전송할 파라메터 정의
  let params = document.getElementById("id").value;

  //open()로 요청 설정
  req.open('get', '/check/'+params);

  //요청 전송
  req.send();
}