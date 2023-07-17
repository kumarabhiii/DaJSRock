# DaJSRock: JavaScript Framework

DaJSRock is a JavaScript Framework implemented in pure javascript.
This framework similar to jQuery for creating customized components for web application development.
Features: Accordion, Grid with pagination, Ajax calls, Modal and Custom attribute etc. 

## Features:
1) User can create modal in very easy way.
2) User can create accordian pan in very simple way.
3) User can fill combobox by writing a very little code.
4) User able to do form validation by writing a some lines code.
5) Handle ajax GET and POST request.
6) User can create Grid (table) With pagination by just defining.

## Steps to use this framework:-
1) Extract the zip File.
2) Then add this JS and CSS files in your project
3) include this below line in your code to integrate JS and CSS file
````
<script src='js/DaJSRock.js'></script>
<link rel="stylesheet" href="css/DaJSRock.css">
````
4) Use any component (see below demos to learn).


# Demo here
###  POST type request Example :

````
<script>
function saveEnquiry()
{
var firstName=$$$("firstName").value();
var lastName=$$$("lastName").value();
var age=$$$("age").value();
var customer={
"firstName" : firstName,
"lastName" :  lastName,
"age" : age
};
var whatever=$$$("whatever");
whatever.html("");
$$$.ajax({
"methodType":"POST",
"url":"servletThree",
"data":customer,
"sendJSON":true,
"success":function(responseData){
var customer=JSON.parse(responseData);
var a="First Name: "+customer.firstName+"<br>";
a=a+"Last Name: "+customer.lastName+"<br>";
a=a+"Age: "+customer.age;
whatever.html(a);
},
"failure":function(){
alert("Some problem");
}
});
}
</script>
````

````
<body>
<h1>Post type request Example</h1> 
<label>First Name </label><br><input type='text' id='firstName'><br><br>
<label>Last Name </label><br><input type='text' id='lastName'><br><br>
<label>Age </label><br><input type='text' id='age'><br><br>
<button type='button' onclick='saveEnquiry()'>Save</button><br>
<br>
<div id='whatever'></div>
</body>
````

### Output : 

![Screenshot 2023-07-16 043651](https://github.com/kumarabhiii/DaJSRock/assets/121662707/828f50af-b4b2-4cfd-8605-8a5c30121f37)



### Get Type Request Example : 

````
<script>
function getDesignation()
{
let titleSpan=$$$("title");
titleSpan.html("");
let code=$$$("code").value();
$$$.ajax({
"url":"servletTwo",
"data":{
"code":code
},
"methodType":"GET",
"success":function(responseData){
// code 
},
"failure":function(){
//code
}
});
}
</script>
````

````
<h1>GET Type request with data Example</h1>
Enter code <input type='text' id='code'>
<button type='button' onclick='getDesignation()'>Get Designation</button><br>
<br>
Title <span id='title'></span>
<br>
<a href='index.html'>Home</a>
````
### Output : 

![Screenshot (626)](https://user-images.githubusercontent.com/69362478/124371218-27c30300-dc9d-11eb-81cf-e0f9896380d0.png)

### Form validation:
````
<script>
// TMJRock user script starts here
function doSomething()
{
return $$$("someForm").isValid({
"nm":{
"required":true,
"maxLength":20,
"errorPane":"nmErrorSection",
"errors":{
"required":"Name required",
"maxLength":"Name cannot exceed 20 characters"
}
},
"ad":{
"required":true,
"errorPane":"adErrorSection",
"errors":{
"required":"Address required"
}
},
"ct":{
"invalid":-1,
"errorPane":"ctErrorSection",
"errors":{
"invalid":"Select city"
}
},
"gender":{
"required":true,
"errorPane":"genderErrorSection",
"errors":{
"required":"select gender"
}
},
"agree":{
"requiredState":true,
"displayAlert":true,
"errors":{
"requiredState":"Select I agree checkbox"
}
}
});
}
</script>
````

````
<body>
<h1>Form validation example</h1>
<form id='someForm' onsubmit='return doSomething()'>
<label>Name</label> <br><input type='text' name='nm' id='nm'> <span id='nmErrorSection'></span><br><br>
<label>Address</label> <br><textarea id='ad' name='ad'></textarea> <span id='adErrorSection'></span><br><br>
<label>Select city</label><br>
<select id='ct' name='ct'>
<option value='-1'>select city</option>
<option value='1'>Ujjain</option>
<option value='2'>Dewas</option>
<option value='3'>Indore</option>
</select>
 <span id='ctErrorSection'></span><br>
<br><br>
<label>Gender &nbsp;&nbsp;&nbsp;</label><br>
Male <input type='radio' name='gender' id='ml' value='M'>&nbsp;&nbsp;&nbsp;
Female <input type='radio' name='gender' id='fe' value='F'>&nbsp;&nbsp;&nbsp;
 <span id='genderErrorSection'></span>
<br><br>
<input type='checkbox' name='agree' id='ag' value='y'> I agree?
<br><br>
<button type='submit'>Registor</button>
</form>
</body>
````
### Output : 

![Screenshot (623)](https://user-images.githubusercontent.com/69362478/124371238-69ec4480-dc9d-11eb-98fc-80e7d1b335dc.png)

After Clicking on Submit button 

![Screenshot (633)](https://user-images.githubusercontent.com/69362478/124382841-0850c800-dce7-11eb-8a23-1d243cdb91f4.png)

### Fill combobox:
````
<script>
function populateDesignations()
{
$$$.ajax({
"url": "servletOne",
"methodType": "GET",
"success": function(responseData){
var designations=JSON.parse(responseData);
$$$("designationCode").fillComboBox({
"dataSource": designations,
"text" : "title",
"value": "code",
"firstOption" : {
"text": "<select designation>",
"value" : "-1"
}
});
},
"failure": function(){
alert("Some problem");
}
});
}
window.addEventListener('load',populateDesignations);
</script>
````

````
<body>
<h1>Fill ComboBox Example</h1>
<select id='designationCode'>
</select>
</body>
````

![Screenshot (632)](https://user-images.githubusercontent.com/69362478/124382708-75179280-dce6-11eb-97c3-6c27938cdd78.png)



### Creating accordian panel:
 code to write in between <body> tag
 
 ````
 <div accordian="true">
<h3 accordianHeaderBackgroundColor="#4033FF ">Heading 1</h1>
<div accordianBackgroundColor="#ffe3ec">
1 Whatever whatever
2 Whatever whatever
3 Whatever whatever<br>
4 Whatever whatever
5 Whatever whatever
6 Whatever whatever<br>
7 Whatever whatever
8 Whatever whatever
9 Whatever whatever
</div>
<h3 accordianHeaderBackgroundColor="#4033FF">Heading 2</h1>
<div accordianBackgroundColor="#ffe3ec">
11 Whatever whatever
22 Whatever whatever
33 Whatever whatever
44 Whatever whatever
55 Whatever whatever
66 Whatever whatever
77 Whatever whatever
</div>
<h3 accordianHeaderBackgroundColor="#4033FF">Heading 3</h1>
<div accordianBackgroundColor="#ffe3ec">
111 Whatever whatever
222 Whatever whatever
333 Whatever whatever
444 Whatever whatever
555 Whatever whatever
666 Whatever whatever
777 Whatever whatever
</div>
</div>

<div id='gogo' accordian="true">
<h3>Heading 1000</h1>
<div>
1 Whatever whatever
2 Whatever whatever
3 Whatever whatever
4 Whatever whatever
5 Whatever whatever
6 Whatever whatever
7 Whatever whatever
</div>
<h3>Heading 2000</h1>
<div>
11 Whatever whatever
22 Whatever whatever
33 Whatever whatever
44 Whatever whatever
55 Whatever whatever
66 Whatever whatever
77 Whatever whatever
</div>

<h3>Heading 3000</h1>
<div>
111 Whatever whatever
222 Whatever whatever
333 Whatever whatever
444 Whatever whatever
555 Whatever whatever
666 Whatever whatever
777 Whatever whatever
</div>

</div>

 ````
 
![Screenshot (629)](https://user-images.githubusercontent.com/69362478/124382725-911b3400-dce6-11eb-8c9a-0e85291d5dff.png)
 
 ### Creating modal Window:
code to write in between <script> tag
````
<script>
// user written functions
function abBeforeOpening()
{
return true;
}
function abOpened()
{
}
function abBeforeClosing()
{
return true;
}
function abClosed()
{
}
function createModal1()
{
$$$.modals.show("ab");
}
</script>
````
code to write in between <body> tag
````
<button onclick='createModal1()'>Show First Modal</button>
<div id='ab'  style='display:none' forModal='true' header="some heading"
footer="some footer" size="600x300" closeButton="true"
maskColor="#6C66CF" modalBackgroundColor="#e4f2f2" 
beforeOpening="abBeforeOpening()"
afterOpening="abOpened()"
beforeClosing="abBeforeClosing()"
afterClosing="abClosed()"
>
God is great<br>
God is great<br>
God is great<br>
<input type='text' id='myTextBox' value='Great'>
God is great<br>
God is great<br>
God is great<br>
God is great<br>
God is great<br>
God is great<br>
God is great<br>
God is great<br>
God is great<br>
Last Line

</div>
<button onclick='xyz()'>Cool button</button>


````
 ### Output
 
 ![Screenshot (628)](https://user-images.githubusercontent.com/69362478/124383110-56b29680-dce8-11eb-9b75-115e5e1d21da.png)


### Grid (Table) With pagination


### Output

![Screenshot 2023-07-16 044445](https://github.com/kumarabhiii/DaJSRock/assets/121662707/9f5c081a-388e-4695-8c8b-6da384eae457)



