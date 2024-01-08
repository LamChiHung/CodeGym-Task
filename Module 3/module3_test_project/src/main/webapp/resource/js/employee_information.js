let link = document.querySelectorAll(".btn-danger");
link.forEach((element) => {
    element.addEventListener("click", (event) => {
            event.preventDefault();
            let result = window.confirm("Xác nhận xóa nhân viên!")
            if (result) {
                window.location.href = element.href;
            }
        }
    )
})