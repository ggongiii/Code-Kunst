/**
 * 
 */
 
let bannerIndex = 0;
let productIndex = 0;
let bestsellerIndex = 0;

function slide(direction, type) {
    if (type === 'banner') {
        const banners = document.querySelector('.banner-inner');
        const bannerCount = banners.children.length;
        bannerIndex = (bannerIndex + direction + bannerCount) % bannerCount;
        banners.style.transform = `translateX(-${bannerIndex * 100}%)`;
    } else if (type === 'products') {
        const products = document.querySelectorAll('.products-inner')[0];
        const productCount = products.children.length;
        productIndex = (productIndex + direction + productCount) % productCount;
        products.style.transform = `translateX(-${productIndex * 100}%)`;
    } else if (type === 'bestseller') {
        const bestsellers = document.querySelectorAll('.products-inner')[1];
        const bestsellerCount = bestsellers.children.length;
        bestsellerIndex = (bestsellerIndex + direction + bestsellerCount) % bestsellerCount;
        bestsellers.style.transform = `translateX(-${bestsellerIndex * 100}%)`;
    }
}