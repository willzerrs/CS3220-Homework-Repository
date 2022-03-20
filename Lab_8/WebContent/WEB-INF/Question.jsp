<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driving Test Quiz</title>
</head>
<body>
${questionList[param.nextIndex].description} <br>
1. ${questionList[param.nextIndex].answerA} <br>
2. ${questionList[param.nextIndex].answerB} <br>
3. ${questionList[param.nextIndex].answerC} <br>
Correct answer: ${questionList[param.nextIndex].correctAnswer} <br>
<br>
<a href="DrivingTestBrowser?nextIndex=${nextIndex+1}">Next</a>
</body>
</html>