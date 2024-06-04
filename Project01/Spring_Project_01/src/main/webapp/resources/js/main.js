let bannerIndex = 0;
let productIndex = 0;
let bestsellerIndex = 0;

function slide(direction, type) {
    if (type === 'banner') {
        const banners = document.querySelector('.banner-inner');
        const bannerCount = banners.children.length;
        bannerIndex = (bannerIndex + direction + bannerCount) % 2; // 2개의 슬라이드만 사용
        banners.style.transform = `translateX(-${bannerIndex * 100}%)`;
    } else if (type === 'products') {
        const products = document.querySelectorAll('.products-inner')[0];
        const productCount = products.children.length;
        productIndex = (productIndex + direction + productCount) % 2; // 2개의 슬라이드만 사용
        products.style.transform = `translateX(-${productIndex * 100}%)`;
    } else if (type === 'bestseller') {
        const bestsellers = document.querySelectorAll('.products-inner')[1];
        const bestsellerCount = bestsellers.children.length;
        bestsellerIndex = (bestsellerIndex + direction + bestsellerCount) % 2; // 2개의 슬라이드만 사용
        bestsellers.style.transform = `translateX(-${bestsellerIndex * 100}%)`;
    }
}

// 2초마다 자동으로 슬라이드
setInterval(() => {
    slide(1, 'banner');
    slide(1, 'products');
    slide(1, 'bestseller');
}, 2000);


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
}

// 기본으로 첫 번째 탭 열기
document.addEventListener("DOMContentLoaded", function() {
    document.querySelector(".tablink").click();
});

