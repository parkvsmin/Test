
//파일의 갯수를 지정하는 변수
let count = 0;


$("#fileAdd").click(function () {
  if (flag) {
    let size = $("#fileAddResult").attr("data-file-size");
      if(size==undefined) {
        size=0;
      }
    count = size;
    flag = false;
  }

  if (count < 5) {
    let r = '<div class="mb-3">';
    r = r + '<label for="contents" class="form-label">File</label>';
    r = r + '<input type="file" name="files" >';
    r = r + '<button type="button" class="del">X</button>'
    r = r + '</div>';
    $("#fileAddResult").append(r);
    count++;
  } else {
    alert("최대 5개")
  }

});


$("#fileAddResult").on("click", ".del", function () {
  $(this).parent().remove();
  count--;
});

let flag = true;
// 글 수정시 첨부파일 삭제
$(".deleteFile").click(function () {
  //DB, HDD에 파일 삭제
  let check = confirm("삭제한다");
  if (flag) {
    let size = $("#fileAddResult").attr("data-file-size");
    if(size==undefined) {
      size=0;
    }
    count = size;
    flag = false;
  }

  if (check) {

    let fileNum = $(this).attr("data-file-num");
    console.log("Before Result This", $(this));
    const btn = $(this);
    $.ajax({
      type: "POST",
      url: "fileDelete",
      data: {
        fileNum: fileNum
      },
      success: function (result) {
        console.log("Result : ", result)
        console.log("After Result This", $(this));
        $(btn).parent().remove();
        count--;
      },
      error: function () {
        console.log("에러발생");
      }
    });

  }
});