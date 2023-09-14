window.addEventListener('pluginIsotopeReady', () => {
	document.querySelector('.custom-filter').querySelectorAll('li:not(.custom-filter-reset)').forEach(el => {
		var elementFilter = el.querySelector('[data-filter]').getAttribute('data-filter'),
			elementFilterContainer = el.closest('.custom-filter').getAttribute('data-container');

		elementFilterCount = Number(document.querySelector(elementFilterContainer).querySelectorAll(elementFilter).length);

		if (el.querySelector('span')) {
			el.querySelector('span').innerText = elementFilterCount;
		}
	});
});

window.addEventListener('pluginSwiperReady', () => {
	let introSwiper = new Swiper('.swiper-container', {
		spaceBetween: 20,
		centeredSlides: false,
		autoHeight: true,
		speed: 3300,
		loop: true,
		autoplay: {
			delay: 1,
			disableOnInteraction: true,
		},
		allowTouchMove: false,
		breakpoints: {
			1: {
				slidesPerView: 2
			},
			576: {
				slidesPerView: 3
			},
			768: {
				slidesPerView: 4
			},
			992: {
				slidesPerView: 6
			}
		}
	});

	window.addEventListener('scroll', () => {
		if (document.querySelector('.slider-inner').classList.contains('is-in-viewport')) {
			if (!introSwiper.el.classList.contains('intro-swiper-resumed')) {
				introSwiper.autoplay.resume();
				introSwiper.el.classList.remove('intro-swiper-paused');
				introSwiper.el.classList.add('intro-swiper-resumed');
			}
		} else {
			if (!introSwiper.el.classList.contains('intro-swiper-paused')) {
				introSwiper.autoplay.pause();
				introSwiper.el.classList.remove('intro-swiper-resumed');
				introSwiper.el.classList.add('intro-swiper-paused');
			}
		}
	}, { passive: true });
});

var swiper = new Swiper(".swiper-tab-container", {
	pagination: ".swiper-tab-pagination",
	slidesPerView: 1,
	paginationClickable: true,
	loop: true,
	paginationBulletRender: function(index, className) {
		var tabsName = ["[우표전설관]", "[우표예술관]", "[우표대화관]", "[우표역사관]"];
		if (index === tabsName.length - 1) {
			return '<span id="tab-swiper-' + index + '" class="' + className + '">' + tabsName[index] + "</span>";
		}
		return '<span id="tab-swiper-' + index + '" class="' + className + '">' + tabsName[index] + "</span>";
	},
	nextButton: '.swiper-button-next',
	prevButton: '.swiper-button-prev',
});