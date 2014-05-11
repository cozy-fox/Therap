var priority={};
priority['plus']     = 0;
priority['minus']    = 0;
priority['multiply'] = 0;
priority['division'] = 0;

var correspondingChar={};
correspondingChar['plus']     = '+';
correspondingChar['minus']    = '-';
correspondingChar['multiply'] = '\xD7';
correspondingChar['division'] = '\xF7';
correspondingChar['percent']  = '%';
correspondingChar['square']   = '\xB2';
correspondingChar['open_bracket']  = '(';
correspondingChar['close_bracket'] = ')';

var infoArr = [
    {
        linkText: '&nbsp;C&nbsp;'
    },{
        linkText: '&nbsp;&divide;&nbsp;'
    }
];

function init(){
    document.getElementById("input_editor_textfield").value = "";

    createTable();
}
window.onload=init;

function createTable(){
    var tr = document.createElement("tr");
    tr.className = "button_row";

    var td = document.createElement("td");
    td.className = "button_col";

    var aLink = document.createElement("a");
    aLink.className="a_demo_one";
    //aLink.addEventListener("click", buttonProcessor, false);
    aLink.onclick = function(){buttonProcessor('equal',1)};
    var linkText = document.createTextNode("&nbsp;&nbsp;=&nbsp;&nbsp;");
    aLink.appendChild(linkText);

    td.appendChild();

}
function editorOnChangeListener(value){
    var i;
    for(i=0; i<value.length; i++){
        if (buttonProcessor(value.charAt(i), 0) == false){
            alert(value.charAt(i));
            break;
        }
    }

    if ( i== value.length ) {
        document.getElementById("messageDiv").style.display = "none";
        return true;
    }
    else return false;
}

function buttonProcessor(value, other){

    if ( isNum(value) ){
        if (other) viewOnScreen(value);
        document.getElementById("messageDiv").style.display = "none";
        return true;
    } else if ( isOp(value)){
        if (other) viewOnScreen(correspondingChar[value]);
        document.getElementById("messageDiv").style.display = "none";
        return true;
    } else if ( isClear(value) ){
        clearScreen();
        document.getElementById("messageDiv").style.display = "none";
        return true;
    } else if ( isBackSpace(value) ){
        if (other) backSpaceOperation();
        document.getElementById("messageDiv").style.display = "none";
        return true;
    } else if ( isSqrt(value) ){
        if (other) sqrtOperation();
        document.getElementById("messageDiv").style.display = "none";
        return true;
    } else if ( isPercent(value) ){
        if (other) percentOperation(value);
        document.getElementById("messageDiv").style.display = "none";
        return true;
    } else if ( isBracket(value) ){
        document.getElementById("messageDiv").style.display = "none";
        if (other) viewOnScreen(correspondingChar[value]);
        return true;
    } else if ( isSquare(value) ){
        document.getElementById("messageDiv").style.display = "none";
        if (other) squareOperation(value);
        return true;
    } else if ( isEqual(value) ){
        document.getElementById("messageDiv").style.display = "none";
        showResult();
    } else {
        document.getElementById("messageDiv").innerHTML = "<p>Invalid Input</p>";
        document.getElementById("messageDiv").style.display = "block";
        return false;
    }
}



function viewOnScreen(val){
    var textFieldVal = document.getElementById("input_editor_textfield").value;
    document.getElementById("input_editor_textfield").value = textFieldVal+val.toString();
    return;
}
function clearScreen(){
    document.getElementById("input_editor_textfield").value = "";
    return;
}
function backSpaceOperation(){
    var textFieldVal = document.getElementById("input_editor_textfield").value;
    document.getElementById("input_editor_textfield").value = textFieldVal.substring(0,textFieldVal.length-1);
    return;
}
function sqrtOperation(){
    viewOnScreen('\u221a');
    viewOnScreen('(');
}
function percentOperation(val){
    if (val=='%') viewOnScreen(val);
    else viewOnScreen(correspondingChar[val]);
}
function squareOperation(val){
    if (val=='\xB2') viewOnScreen(val);
    else viewOnScreen(correspondingChar[val]);

}




function isNum(val){
    if ( val >= 0 && val <= 9 ) return true;
    else if ( val == '.' ) return true;

    return false;
}
function isOp(val){
    if (val=='plus' || val=='minus' || val=='multiply' || val=='division' ) return true;
    else if ( val=='+' || val=='-' || val=='\xD7' || val=='\xF7' ) return true;
    else return false;
}
function isClear(val){
    if (val=='clear') return true;
    return false;
}
function isBackSpace(val){
    if (val=='back') return true;
    return false;
}
function isEqual(val){
    if (val=='equal') return true;
    return false;
}
function isBracket(val){
    if (val=='open_bracket' || val=='close_bracket' ) return true;
    else if (val == '(' || val == ')' ) return true;
    return false;
}
function isSqrt(val){
    if (val=='sqrt') return true;
    else if (val == '\u221a') return true;
    return false;
}
function isPercent(val){
    if (val == '%') return true;
    else if (val == 'percent') return true;
    return false;
}
function isSquare(val){
    if (val == 'square') return true;
    else if (val == '\xB2') return true;
    return false;
}
function showResult(){
    var currentText = document.getElementById("input_editor_textfield").value;
    var currentTextShow = currentText;
    if ( editorOnChangeListener(currentText) == true ){

        currentText = currentText.replace('\xF7', "/");
        currentText = currentText.replace('\xD7', "*");
        currentText = currentText.replace('\u221a', "Math.sqrt");
        currentText = currentText.replace(new RegExp('%','g'),"/100");

        var squarePattern = /\d+\xB2/g;
        var squareMatches = currentText.match(squarePattern);
        if (squareMatches!=null)
            for(var i=0; i<squareMatches.length; i++){
            var replaceString = squareMatches[i].substring(0, squareMatches[i].length-1);
            replaceString = replaceString + "*" + replaceString;
            alert(replaceString);
            currentText = currentText.replace(squareMatches[i], replaceString);
        }

        //alert(currentText);
        document.getElementById("input_viewer_textfield").value = currentTextShow+" =";
        document.getElementById("input_editor_textfield").value = eval(currentText);
    }
}