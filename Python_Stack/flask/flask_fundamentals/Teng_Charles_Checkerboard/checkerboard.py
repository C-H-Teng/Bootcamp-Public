from flask import Flask, render_template
app = Flask(__name__, template_folder=".")

@app.route("/")
def check_brd():
    return render_template("checkerboard.html", col=8, row=8, col1="red", col2="black")

@app.route("/4")
def check_brd_row():
    return render_template("checkerboard.html", col=8, row=4, col1="red", col2="black")

@app.route("/<int:x>/<int:y>")
def check_brd_row_col(x,y):
    return render_template("checkerboard.html", col=x, row=y, col1="red", col2="black")

@app.route("/<int:x>/<int:y>/<string:color1>/<string:color2>")
def check_brd_row_col1_col2(x,y,color1,color2):
    return render_template("checkerboard.html", col=x, row=y, col1=color1, col2=color2)

if __name__ == "__main__":
    app.run(debug = True)