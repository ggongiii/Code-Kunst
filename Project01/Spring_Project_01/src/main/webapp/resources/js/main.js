let currentSlide = 0;

function slide(direction) {
    const slides = document.querySelectorAll('.book-slide');
    const totalSlides = slides.length;
    
    currentSlide += direction;
    if (currentSlide < 0) {
        currentSlide = totalSlides - 1;
    } else if (currentSlide >= totalSlides) {
        currentSlide = 0;
    }
    
    const sliderInner = document.querySelector('.book-slider-inner');
    sliderInner.style.transform = `translateX(-${currentSlide * 100}%)`;
}

function openSection(evt, sectionName) {
    // 모든 탭 콘텐츠 숨기기
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    // 모든 탭 링크의 활성화 상태 제거
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    // 선택된 섹션 보여주기
    document.getElementById(sectionName).style.display = "block";
    evt.currentTarget.className += " active";
    
    // 첫 10개의 책만 노출
    var books = document.getElementById(sectionName).getElementsByClassName("product");
    for (i = 0; i < books.length; i++) {
        if (i < 10) {
            books[i].style.display = "block";
        } else {
            books[i].style.display = "none";
        }
    }
}

// 기본으로 첫 번째 탭 열기
document.addEventListener("DOMContentLoaded", function() {
    document.querySelector(".tablink").click();
});