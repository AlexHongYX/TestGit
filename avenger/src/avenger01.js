// var my="我";
// document.write(my+"<br/>");
// document.write("草拟吗");
// alert("你妈死了？");
// confirm("你妈死了？");
// prompt("你妈死了？");
// window.open("www.baidu.com");
// function Wopen(){
//     window.open("https://www.baidu.com","_blank","width=600,height=400,top:100,left=0,")
//
// }
// function Wclose(){
//     window.close();
// }
// var mother = document.getElementById("con");
// mother.innerHTML="你妈死了";
// document.write("hehe"+mother.innerHTML);
// mother.style.backgroundColor="red";
// mother.style.display="none";
//
// document.write("oh"+mother.className);
// mother.className="mother";
// document.write("oh"+mother.className);
// function printMother(age) {
//     var name="你妈死了";
//     return name+age;
// }
//
// var returnNum = printMother(1);
// document.write(returnNum);
// var con = document.getElementById("con");
// con.innerHTML=returnNum+"hehe";
// document.write("hehe"+con.innerHTML);


// var a = document.getElementById("con").innerHTML;
// document.write(a);
//
// function thisChange(){
//     alert("你改你妈");
// }
// var Udate = new Date(2012,10,1);
// alert(Udate);
// var stringTest = "我草你妈";
// var string = stringTest.split("");
// alert(string);
var mydom = document.getElementsByTagName("input");
document.write(mydom[1].value);
mydom[1].setAttribute("value","你妈炸了")
var oo = mydom[1].getAttribute("name");
document.write(oo);
