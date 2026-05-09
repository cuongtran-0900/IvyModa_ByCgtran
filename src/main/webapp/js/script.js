const header = document.querySelector('header');
if (header) {
  window.addEventListener('scroll', () => {
    header.classList.toggle('sticky', window.scrollY > 0);
  });
}

const imageItems = document.querySelectorAll('.aspect-ratio-169 img');
const imageContainer = document.querySelector('.aspect-ratio-169');
const dotItems = document.querySelectorAll('.dot');
let sliderIndex = 0;

if (imageItems.length && imageContainer && dotItems.length) {
  imageItems.forEach((image, idx) => {
    image.style.left = `${idx * 100}%`;
    image.style.position = 'absolute';
    image.style.top = '0';
    image.style.width = '100%';
    image.style.height = '100%';
    image.style.objectFit = 'cover';

    dotItems[idx]?.addEventListener('click', () => {
      setSlider(idx);
    });
  });

  function setSlider(index) {
    sliderIndex = index;
    imageContainer.style.position = 'relative';
    imageContainer.style.left = `-${index * 100}%`;
    imageContainer.style.transition = 'left 0.5s ease';
    document.querySelector('.dot.active')?.classList.remove('active');
    dotItems[index]?.classList.add('active');
  }

  function autoSlide() {
    sliderIndex += 1;
    if (sliderIndex >= imageItems.length) {
      sliderIndex = 0;
    }
    setSlider(sliderIndex);
  }

  setSlider(0);
  setInterval(autoSlide, 5000);
}
