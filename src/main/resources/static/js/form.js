$(document).ready(function () {

    var $newQuestionButton = $('#newQuestionButton'),
        $questionsGroup = $('#questionsGroup'),
        $saveFormButton = $('#saveFormButton');

    $newQuestionButton.on('click', function () {
        $questionsGroup.append("<div class=\"form-group question\">\n" +
            "    <div class=\"form-group\">\n" +
            "        <input class=\"form-control question-title\" name='questionTitle' type=\"text\" placeholder=\"Question title\"/>\n" +
            "    </div>\n" +
            "    <div class=\"form-group answers\">\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <button type=\"button\" class=\"btn btn-success\" name=\"addAnswerButton\">Add answer</button>\n" +
            "    <button type=\"button\" class=\"btn btn-danger\" name=\"deleteQuestionButton\">Delete question</button>\n" +
            "\n" +
            "</div>");
    });

    $saveFormButton.on('click', function (event) {
       var form = {};

       form.title = $('input[name=formTitle]').val();
       form.comment = $('input[name=formComment]').val();
       form.questions = [];

       $('.question').each(function () {
           var question = {};
           question.title = $(this).find('input[name=questionTitle]').val();
           question.answers = [];

           $(this).find('.answer').each(function () {
               var answer = {};
              answer.title = $(this).find('input[name=answerTitle]').val();
              answer.isTrue = $(this).find('input[name=isAnswerTrue]').is(':checked');
              question.answers.push(answer);
           });
           form.questions.push(question);
       });

       var json = JSON.stringify(form);

      $.ajax({
           url: "/saveForm",
           dataType: "json",
           type: "post",
           data: json,
           async:false,
           beforeSend: function(xhr) {
               xhr.setRequestHeader("Accept", "application/json");
               xhr.setRequestHeader("Content-Type", "application/json");
           },
           success: function(data) {
               console.log(data);
           }
       });

      window.location.replace("/");


    });
});

$(document).on('click', 'button[name=deleteQuestionButton]', function () {
    $(this).parent().remove();
});

$(document).on('click', 'button[name=addAnswerButton]', function () {
    $(this).prev().prev().append("<div class=\"form-group answer\">\n" +
        "    <div class=\"row\">\n" +
        "        <div class=\"offset-1 col-md-8\">\n" +
        "            <input class=\"form-control\" name='answerTitle' type=\"text\" placeholder=\"Answer\"/>\n" +
        "        </div>\n" +
        "        <div class=\"col-md-1\">\n" +
        "            <input class=\"form-control\" name='isAnswerTrue' type=\"checkbox\"/>\n" +
        "        </div>" +
        "        <div class=\"col-md-1\">\n" +
        "            <button type=\"button\" class=\"btn btn-danger\" name=\"deleteAnswerButton\">Delete</button>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</div>");
});

$(document).on('click', 'button[name=deleteAnswerButton]', function () {
    $(this).parent().parent().parent().remove();
});