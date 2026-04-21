from PIL import Image
import os

def compress_image(input_path, output_path, target_size_mb=1.5):
    """
    压缩图片到目标大小
    :param input_path: 输入图片路径
    :param output_path: 输出图片路径
    :param target_size_mb: 目标大小（MB）
    """
    target_size = target_size_mb * 1024 * 1024  # 转换为字节
    
    # 打开图片
    img = Image.open(input_path)
    
    # 如果是RGBA模式，转换为RGB
    if img.mode == 'RGBA':
        img = img.convert('RGB')
    
    # 获取原始文件大小
    original_size = os.path.getsize(input_path)
    print(f"原始文件大小: {original_size / 1024 / 1024:.2f} MB")
    
    # 二分法查找合适的质量参数
    quality = 85
    min_quality = 50
    max_quality = 95
    
    while min_quality <= max_quality:
        # 保存到临时位置测试大小
        img.save(output_path, 'JPEG', quality=quality, optimize=True)
        current_size = os.path.getsize(output_path)
        
        print(f"尝试质量 {quality}: {current_size / 1024 / 1024:.2f} MB")
        
        # 如果大小合适（在目标大小的95%-105%之间），就完成
        if target_size * 0.95 <= current_size <= target_size * 1.05:
            break
        
        # 调整质量参数
        if current_size > target_size:
            max_quality = quality - 1
        else:
            min_quality = quality + 1
        
        quality = (min_quality + max_quality) // 2
        
        # 防止无限循环
        if max_quality - min_quality <= 1:
            break
    
    final_size = os.path.getsize(output_path)
    print(f"压缩后文件大小: {final_size / 1024 / 1024:.2f} MB")
    print(f"压缩率: {(1 - final_size/original_size) * 100:.1f}%")
    print(f"保存到: {output_path}\n")

# 处理两张图片
image1_input = r"G:\【02】个人信息\唐东平居转户\居转户成果归集\IMG_20260421_230913.jpg"
image1_output = r"G:\【02】个人信息\唐东平居转户\居转户成果归集\IMG_20260421_230913_compressed.jpg"

image2_input = r"G:\【02】个人信息\唐东平居转户\居转户成果归集\IMG_20260421_230920.jpg"
image2_output = r"G:\【02】个人信息\唐东平居转户\居转户成果归集\IMG_20260421_230920_compressed.jpg"

print("=" * 60)
print("开始压缩图片...")
print("=" * 60)

print("\n处理第一张图片:")
print("-" * 60)
compress_image(image1_input, image1_output, target_size_mb=1.5)

print("\n处理第二张图片:")
print("-" * 60)
compress_image(image2_input, image2_output, target_size_mb=1.5)

print("=" * 60)
print("压缩完成！")
print("=" * 60)
