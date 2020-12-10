$.validator.addMethod("validatePassword", function(value, element) {
        return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
    }, "Hãy nhập password từ 8 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");
    $(function() {
        $("form[name='myform']").validate({
            rules: {
            	userName: "required",
            	fullName: "required",
                phone: "required",
                password: {
                    required: true,
                    validatePassword: true,
                    minlength: 8
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
            	fullName: "Bạn chưa nhập họ và tên",
                userName: "Bạn chưa nhập tên đăng nhập",
                phone: "bạn chưa nhập số điện thoại",
                password: {
                    required: "Bạn chưa nhập mật khẩu",
                    minlength: "Yêu cầu mật khẩu dài hơn 8 kí tự",
                    validatePassword: "Yêu cầu password từ 8 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số"
                },
                email: {
                    required: "Bạn chưa nhập email",
                    email: "Vui lòng nhập đúng email"
                }
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });