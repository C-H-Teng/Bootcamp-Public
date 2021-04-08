from flask import Flask, render_template
app = Flask(__name__, template_folder=".")

@app.route("/")
def test():
    return "Test 123"

@app.route("/play")
def play():
    return render_template("playground.html", times=3, bg_color="blue")

@app.route("/play/<int:x>")
def play_x(x):
    return render_template("playground.html", times=x, bg_color="blue")

@app.route("/play/<int:x>/<string:bg_color>")
def play_x_color(x,bg_color):
    return render_template("playground.html", times=x, bg_color=bg_color)

if __name__ == "__main__":
    app.run(debug = True)