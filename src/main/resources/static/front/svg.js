$(document).ready(function () {
  $("#text-container h1").lettering();
  setup();

  $("#replay").click(function () {
    refresh();
    setup();
  });

  $("#color-toggle").click(function () {
    $("html").toggleClass("dark-mode");
  });

  $("#turkey > *, #leaf > *:not(.dot), #rays > *").each(function () {
    var length_stroke = $(this).get(0).getTotalLength();
    $(this).css({
      "stroke-dasharray": length_stroke + " " + length_stroke,
      "stroke-dashoffset": length_stroke,
    });
  });

  $.fn.parallax = function (resistance, mouse) {
    $el = $(this);
    TweenLite.to($el, 0.2, {
      x: -((mouse.clientX - window.innerWidth / 2) / resistance),
      y: -((mouse.clientY - window.innerHeight / 2) / resistance),
    });
  };
});

function refresh() {
  $("#sun-container").removeClass("sun-animation");
  $("#rays-container").removeClass("ray-animation");
  $("#leaf-container").removeClass("leaf-animation");
  $("#turkey > *, #leaf > *:not(.dot)").removeClass("stroke-animation");
  $("#rays > *").removeClass("ray-stroke-animation");
  $("#leaf > .dot").removeClass("leaf-dot-animation");
  $("#leaf-container span").removeClass("leaf-shadow-animation");
  $("#text-container h2").removeClass("h2-animation");
  $("#text-container h1 span").removeClass("h1-animation");
}

function animations() {
  $("#sun-container").addClass("sun-animation");
  $("#rays-container").addClass("ray-animation");
  $("#leaf-container").addClass("leaf-animation");
  $("#turkey > *, #leaf > *:not(.dot)").addClass("stroke-animation");
  $("#rays > *").addClass("ray-stroke-animation");
  $("#leaf > .dot").addClass("leaf-dot-animation");
  $("#leaf-container span").addClass("leaf-shadow-animation");
  $("#text-container h2").addClass("h2-animation");
  $("#text-container h1 span").addClass("h1-animation");
}

function setup() {
  $("#svgcontainer").hide(0).fadeIn(800);

  animations();

  setTimeout(function () {
    $(document).mousemove(function (e) {
      $("#sun-container #sun").parallax(150, e);
      $("#text-container h1, #text-container h2, #rays-container").parallax(
        350,
        e
      );
      $("#turkey-container").parallax(60, e);
      $("#leaf-container #leaf").parallax(200, e);
    });
  }, 2250);

  $("button#replay").hide().delay(2500).fadeIn(800);
}
